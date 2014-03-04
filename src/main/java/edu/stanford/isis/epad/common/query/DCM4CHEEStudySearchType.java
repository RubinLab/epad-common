package edu.stanford.isis.epad.common.query;

public enum DCM4CHEEStudySearchType {
	PATIENT_NAME("patientName"), PATIENT_ID("patientId"), ASSESION_NUM("accessionNum"), EXAM_TYPE("examType"), STUDY_DATE(
			"studyDate"), WORK_LIST_NAME("workListName");

	private String name;

	private DCM4CHEEStudySearchType(String type)
	{
		this.name = type;
	}

	@Override
	public String toString()
	{
		return name;
	}
}
