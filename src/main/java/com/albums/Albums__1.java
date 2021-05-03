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
"paging"
})
@Generated("jsonschema2pojo")
public class Albums__1 {

@JsonProperty("data")
private List<Datum> data = null;
@JsonProperty("paging")
private Paging__1 paging;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* No args constructor for use in serialization
*
*/
public Albums__1() {
}

/**
*
* @param data
* @param paging
*/
public Albums__1(List<Datum> data, Paging__1 paging) {
super();
this.data = data;
this.paging = paging;
}

@JsonProperty("data")
public List<Datum> getData() {
return data;
}

@JsonProperty("data")
public void setData(List<Datum> data) {
this.data = data;
}

@JsonProperty("paging")
public Paging__1 getPaging() {
return paging;
}

@JsonProperty("paging")
public void setPaging(Paging__1 paging) {
this.paging = paging;
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
sb.append(Albums__1 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
sb.append("data");
sb.append('=');
sb.append(((this.data == null)?"<null>":this.data));
sb.append(',');
sb.append("paging");
sb.append('=');
sb.append(((this.paging == null)?"<null>":this.paging));
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