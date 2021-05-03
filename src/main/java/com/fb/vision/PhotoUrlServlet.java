package com.fb.vision;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.albums.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.appengine.repackaged.com.google.gson.Gson;
import com.google.appengine.repackaged.com.google.gson.JsonArray;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;
import com.google.cloud.datastore.ProjectionEntity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StructuredQuery.OrderBy;
import com.google.cloud.datastore.StructuredQuery.PropertyFilter;
import com.google.cloud.datastore.Value;
import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.cloud.vision.v1.LocalizedObjectAnnotation;
import com.google.cloud.vision.v1.Feature.Type;
import com.google.protobuf.ByteString;
import java.util.*;


/**
 * Servlet implementation class PhotoUrlServlet
 */
@WebServlet("/UrlofPhotos")
public class PhotoUrlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhotoUrlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
			Query<Entity> query = Query.newEntityQueryBuilder()
	        		.setKind("PhotoDetail")
	        	    .build();
	        QueryResults<Entity> results = datastore.run(query);
	        List<String> labels = new ArrayList<String>();
	        while(results.hasNext()) {
	        	Entity task = results.next();
	        	Value<?> urls = task.getValue("url");
	        	Value<?> lbls = task.getValue("label");
	        	labels.add(lbls.get().toString() + "@" + urls.get().toString());
	        }
	        PrintWriter out = response.getWriter();
	        Gson json = new Gson();
	        out.println(json.toJson(labels));
	        
		} catch(Exception e) {
			System.out.println("Exception in get request : " + e.toString() );
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub new
		//doGet(request, response);
		 
	try {
		 StringBuffer jb = new StringBuffer();
		 String line = null;
		 String name = null;
		 Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
		 List<String> urlsrc = new ArrayList<>();
		 List<String> urlfinal = new ArrayList<>();
		 List<NameUrlLabel> storedata = new ArrayList<NameUrlLabel>();   
/*************************************
			 * Beginning of getting Url from facebook json
			 ***********************************************************/
		    
		System.out.println("inside first try");
	try {
			BufferedReader reader = request.getReader();
		
			while ((line = reader.readLine()) != null)
				jb.append(line);
			System.out.println(jb.toString());
			
			ObjectMapper mapper = new ObjectMapper();
			//@SuppressWarnings("unchecked")
			 
			Albums album =  mapper.readValue(jb.toString(), Albums.class);
			Albums__1  a = album.getAlbums();
		    name = album.getName();
		    //System.out.println("Album 1 : "+ a);			
			List<Datum> d = a.getData();
		    //System.out.println("no of photos in album:" + d.size() );
			for(int i=0;i<d.size();i++)
			{
				Photos p = d.get(i).getPhotos();
				//System.out.println("Album Photos: "+ i +" "+ p);
				if(p != null) {
					List<Datum__1> d1 = p.getData();
					//System.out.println("no of images in data of photos:" + d1.size() );
					for(int j=0;j<d1.size();j++)
					{
						List<AlbumImage> image = d1.get(j).getImages();
						//System.out.println("Image Size " + image.size());
						//System.out.println("Images at : "+ j+ " " + image);
						String src = image.get(0).getSource();
						//System.out.println("Source at : "+ j+ "image is: " + src);
						urlsrc.add(src);
						
					}
				}
			}
			
	}catch(Exception e) { /*report an error*/ System.out.println("Exception in json request parsing:" + e.toString() );}
/*************************************
			 * End of getting Url from facebook json
			 ****************************************************************/
			
			

/*************************************
	 * Begin Querying the db for existing Url 
	 ****************************************************************/	
	
			System.out.println("Nof of url: " + urlsrc.size());
			for(int i=0; i < urlsrc.size(); i++) {
			    String url = urlsrc.get(i);
			   // System.out.println("Source at : "+ url);
			   
			    Query<Entity> query = Query.newEntityQueryBuilder()
		        		.setKind("PhotoDetail")
		        		.setFilter(PropertyFilter.eq("Url", url))
		        	    .build();
		        QueryResults<Entity> results = datastore.run(query);
		         
		        if(!results.hasNext())
		        	urlfinal.add(url);
			}
			System.out.println("Read Existing urlsrc size: {} " + " " + urlfinal.size()); 
/*************************************
			 * End  Querying the db for existing Url 
			 ****************************************************************/			
			
			
/*************************************
			 * conversion of image link to bytes
			 ****************************************************************/			
		//	System.out.println("Nof of url: " + urlsrc.size());
			try {
				
			
			
				String urlf=null;
			
				for(int i=0; i < 10; i++) {
				   
				 urlf = urlfinal.get(i);
				 System.out.println("Source at inside tru : "+ urlf);
				
				 URL imageURL = new URL(urlf); 	    		
				 InputStream in = new BufferedInputStream(imageURL.openStream());
				 ByteArrayOutputStream outbuf = new ByteArrayOutputStream();
			     byte[] buf = new byte[1024];
			     int n = 0;
			     while (-1!=(n=in.read(buf)))
			     {
			     	outbuf.write(buf, 0, n);
			     }
			     outbuf.close();
			     in.close();			
		     			
/**********************************************
				 * Begin Calling Vision API
				 ****************************************************************/	   
			    byte[] imageBytes = outbuf.toByteArray();
				ByteString imgBytes = ByteString.copyFrom(imageBytes);
			    String lbl = "";
				List<AnnotateImageRequest> requests = new ArrayList<>();
			    Image img = Image.newBuilder().setContent(imgBytes).build();
			    Feature feature = Feature.newBuilder().setType(Type.LABEL_DETECTION).build();
			    Feature featureObject = Feature.newBuilder().setType(Type.OBJECT_LOCALIZATION).build();
			    AnnotateImageRequest imgreq =
			    		AnnotateImageRequest.newBuilder().addFeatures(feature).addFeatures(featureObject).setImage(img).build();
			    requests.add(imgreq);
			    ImageAnnotatorClient client = ImageAnnotatorClient.create();
			    BatchAnnotateImagesResponse batchResponse = client.batchAnnotateImages(requests);
			    List<AnnotateImageResponse> imageResponses = batchResponse.getResponsesList();
			    AnnotateImageResponse imageResponse = imageResponses.get(0);
			    
	          
			    if (imageResponse.hasError()) 
			    {		    	
			    	System.out.println("Error on Response from Vision API: \r\n "+ imageResponse.getError().getMessage());  
			    }
			   
			    
		        for (EntityAnnotation annotation : imageResponse.getLabelAnnotationsList()) {
		        	  String label = annotation.getDescription();
		        //	  System.out.println(annotation.getDescription());  
		        	 // System.out.println(annotation.getScore() * 100);  
		        	  lbl += label + ";"; 
		        }
		        //lbl += "/";
		        for (AnnotateImageResponse res : imageResponses) {
		            for (LocalizedObjectAnnotation entity : res.getLocalizedObjectAnnotationsList()) {
		              lbl += entity.getName() + ";";
		            }
		          }
		        storedata.add(new NameUrlLabel(name, urlf, lbl));
		        
		  }//for(int i=0; i < urlsrc.size(); i++)
		 
	     }//try
		catch (Exception e) { /*report an error*/ System.out.println("Exception in Vision API calling : " + e);}
			
			
		/*	for (int i = 0; i < storedata.size(); i++)
	        {
	            System.out.println(storedata.get(i).getName() + " "+ storedata.get(i).getUrl() + " " + storedata.get(i).getLabel() + " ");
	        }*/
/******************************************
			 * End Calling Vision API
			 ***************************************************************************/		
			
			
	
			
/******************************************
			 * Begin Calling Data Storage API
			 ***************************************************************************/		
			
			try {
			     	System.out.println("Data Storage " + storedata.size());
   
					KeyFactory keyFactory = datastore.newKeyFactory().setKind("PhotoDetail");
					
					for (int i = 0; i < storedata.size(); i++)
			        {
						 Key taskKey = datastore.allocateId(keyFactory.newKey());
						 Entity task = Entity.newBuilder(taskKey)
					        	    .set("label", storedata.get(i).getLabel())
					        	    .set("url", storedata.get(i).getUrl())
					        	    .set("name", storedata.get(i).getName())
					        	    .build();			
						 datastore.put(task);
			        }
					 
			}//try
			catch (Exception e) { /*report an error*/ System.out.println("Exception in Vision API or  Data Storage API calling:" + e);}
			
			
			/******************************************
			 * End Calling Data Storage API
			 ***************************************************************************/				
			
		    
	} catch (Exception e) { /*report an  error*/ System.out.println(e);}

	response.setContentType("application/json");  
	response.setCharacterEncoding("UTF-8");
	response.getWriter().write("Facebook photos added successfully from post");	
		
	}
		
}

