package edu.stanford.epad.common.pixelmed;

import com.google.gson.Gson;
import com.pixelmed.anatproc.CodedConcept;

public class SegmentedProperty {
	Integer id;
	String name;
	CodedConcept category;
	CodedConcept type;
	CodedConcept modifier;
	String defColor;
	public SegmentedProperty(String n,String c,String t,String m, String defColor) {
		this.name=n;
		this.category=str2cc(c);
		this.type=str2cc(t);
		this.modifier=str2cc(m);
		this.defColor=defColor;
	}
	public SegmentedProperty(int id,String n,String c,String t,String m, String defColor) {
		this.id=id;
		this.name=n;
		this.category=str2cc(c);
		this.type=str2cc(t);
		this.modifier=str2cc(m);
		this.defColor=defColor;
	}
	
	public SegmentedProperty(){
		this.id=null;
		this.name=null;
		this.category=null;
		this.type=null;
		this.modifier=null;
		this.defColor=null;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CodedConcept getCategory() {
		return category;
	}
	public void setCategory(CodedConcept category) {
		this.category = category;
	}
	public CodedConcept getType() {
		return type;
	}
	public void setType(CodedConcept type) {
		this.type = type;
	}
	public CodedConcept getModifier() {
		return modifier;
	}
	public void setModifier(CodedConcept modifier) {
		this.modifier = modifier;
	}
	public String getDefColor() {
		return defColor;
	}
	public void setDefColor(String defColor) {
		this.defColor = defColor;
	}
	public String toJSON()
	{
		Gson gson = new Gson();

		return gson.toJson(this);
	}
	CodedConcept str2cc(String s){
		if (s==null)
			return null;
		//input (T-D000A;SRT;Anatomical Structure)
		s=s.replace("(", "").replace(")", "");
		String[] str=s.split(";");
		return new CodedConcept(null /* conceptUniqueIdentifier */, null /* SNOMED CID */,
				str[1] /* codingSchemeDesignator */, null /* legacyCodingSchemeDesignator */,
				null /* codingSchemeVersion */, str[0] /* codeValue */, str[2] /* codeMeaning */,
				null /* codeStringEquivalent */, null /* synonynms */);

	}
	public void copyValuesFrom(SegmentedProperty src) {
		this.id=src.id;
		this.name=src.name;
		this.category=src.category;
		this.type=src.type;
		this.modifier=src.modifier;
		this.defColor=src.defColor;
	}
	
}
