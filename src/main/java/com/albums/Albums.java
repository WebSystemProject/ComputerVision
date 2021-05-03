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
"name",
"gender",
"email",
"friends",
"albums",
"id"
})
@Generated("jsonschema2pojo")
public class Albums {

@JsonProperty("name")
private String name;
@JsonProperty("gender")
private String gender;
@JsonProperty("email")
private String email;
@JsonProperty("friends")
private Friends friends;
@JsonProperty("albums")
private Albums__1 albums;
@JsonProperty("id")
private String id;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* No args constructor for use in serialization
*
*/
public Albums() {
}

/**
*
* @param albums
* @param gender
* @param name
* @param id
* @param email
* @param friends
*/
public Albums(String name, String gender, String email, Friends friends, Albums__1 albums, String id) {
super();
this.name = name;
this.gender = gender;
this.email = email;
this.friends = friends;
this.albums = albums;
this.id = id;
}

@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

@JsonProperty("gender")
public String getGender() {
return gender;
}

@JsonProperty("gender")
public void setGender(String gender) {
this.gender = gender;
}

@JsonProperty("email")
public String getEmail() {
return email;
}

@JsonProperty("email")
public void setEmail(String email) {
this.email = email;
}

@JsonProperty("friends")
public Friends getFriends() {
return friends;
}

@JsonProperty("friends")
public void setFriends(Friends friends) {
this.friends = friends;
}

@JsonProperty("albums")
public Albums__1 getAlbums() {
return albums;
}

@JsonProperty("albums")
public void setAlbums(Albums__1 albums) {
this.albums = albums;
}

@JsonProperty("id")
public String getId() {
return id;
}

@JsonProperty("id")
public void setId(String id) {
this.id = id;
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
sb.append(Albums.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
sb.append("name");
sb.append('=');
sb.append(((this.name == null)?"<null>":this.name));
sb.append(',');
sb.append("gender");
sb.append('=');
sb.append(((this.gender == null)?"<null>":this.gender));
sb.append(',');
sb.append("email");
sb.append('=');
sb.append(((this.email == null)?"<null>":this.email));
sb.append(',');
sb.append("friends");
sb.append('=');
sb.append(((this.friends == null)?"<null>":this.friends));
sb.append(',');
sb.append("albums");
sb.append('=');
sb.append(((this.albums == null)?"<null>":this.albums));
sb.append(',');
sb.append("id");
sb.append('=');
sb.append(((this.id == null)?"<null>":this.id));
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