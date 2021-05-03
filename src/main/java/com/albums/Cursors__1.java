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
"before",
"after"
})
@Generated("jsonschema2pojo")
public class Cursors__1 {

@JsonProperty("before")
private String before;
@JsonProperty("after")
private String after;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* No args constructor for use in serialization
*
*/
public Cursors__1() {
}

/**
*
* @param before
* @param after
*/
public Cursors__1(String before, String after) {
super();
this.before = before;
this.after = after;
}

@JsonProperty("before")
public String getBefore() {
return before;
}

@JsonProperty("before")
public void setBefore(String before) {
this.before = before;
}

@JsonProperty("after")
public String getAfter() {
return after;
}

@JsonProperty("after")
public void setAfter(String after) {
this.after = after;
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
sb.append(Cursors__1 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
sb.append("before");
sb.append('=');
sb.append(((this.before == null)?"<null>":this.before));
sb.append(',');
sb.append("after");
sb.append('=');
sb.append(((this.after == null)?"<null>":this.after));
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
