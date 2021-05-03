package com.albums;

import java.util.HashMap;
import java.util.List;
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
"data",
"summary"
})
@Generated("jsonschema2pojo")
public class Friends {

@JsonProperty("data")
private List<Object> data = null;
@JsonProperty("summary")
private Summary summary;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* No args constructor for use in serialization
*
*/
public Friends() {
}

/**
*
* @param summary
* @param data
*/
public Friends(List<Object> data, Summary summary) {
super();
this.data = data;
this.summary = summary;
}

@JsonProperty("data")
public List<Object> getData() {
return data;
}

@JsonProperty("data")
public void setData(List<Object> data) {
this.data = data;
}

@JsonProperty("summary")
public Summary getSummary() {
return summary;
}

@JsonProperty("summary")
public void setSummary(Summary summary) {
this.summary = summary;
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
sb.append(Friends.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
sb.append("data");
sb.append('=');
sb.append(((this.data == null)?"<null>":this.data));
sb.append(',');
sb.append("summary");
sb.append('=');
sb.append(((this.summary == null)?"<null>":this.summary));
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
