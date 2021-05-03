package com.albums;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"height",
"source",
"width"
})
@Generated("jsonschema2pojo")
public class AlbumImage {

@JsonProperty("height")
private long height;
@JsonProperty("source")
private String source;
@JsonProperty("width")
private long width;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* No args constructor for use in serialization
*
*/
public AlbumImage() {
}

/**
*
* @param width
* @param source
* @param height
*/
public AlbumImage(long height, String source, long width) {
super();
this.height = height;
this.source = source;
this.width = width;
}

@JsonProperty("height")
public long getHeight() {
return height;
}

@JsonProperty("height")
public void setHeight(long height) {
this.height = height;
}

@JsonProperty("source")
public String getSource() {
return source;
}

@JsonProperty("source")
public void setSource(String source) {
this.source = source;
}

@JsonProperty("width")
public long getWidth() {
return width;
}

@JsonProperty("width")
public void setWidth(long width) {
this.width = width;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

@Override
public String toString() {
StringBuilder sb = new StringBuilder();
sb.append(AlbumImage.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
sb.append("height");
sb.append('=');
sb.append(this.height);
sb.append(',');
sb.append("source");
sb.append('=');
sb.append(((this.source == null)?"<null>":this.source));
sb.append(',');
sb.append("width");
sb.append('=');
sb.append(this.width);
sb.append(',');
sb.append("additionalProperties");
sb.append('=');
sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
sb.append(',');
if (sb.charAt((sb.length()- 1)) == ',') {
sb.setCharAt((sb.length()- 1), ']');
} else {
sb.append(']');
}
return sb.toString();
}

}