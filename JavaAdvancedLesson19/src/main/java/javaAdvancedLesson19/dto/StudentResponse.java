package javaAdvancedLesson19.dto;

public class StudentResponse {
	private String firstName;
	private String lastName;
	private Integer age;
	private String fileName;
	private String fileType;
	private String fileDownloadUri;
	private long size;

	public StudentResponse() {
	}

	public StudentResponse(String firstName, String lastName, Integer age, String fileName, String fileType,
			String fileDownloadUri, long size) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.fileName = fileName;
		this.fileType = fileType;
		this.fileDownloadUri = fileDownloadUri;
		this.size = size;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileDownloadUri() {
		return fileDownloadUri;
	}

	public void setFileDownloadUri(String fileDownloadUri) {
		this.fileDownloadUri = fileDownloadUri;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "StudentResponse [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", fileName="
				+ fileName + ", fileType=" + fileType + ", fileDownloadUri=" + fileDownloadUri + ", size=" + size + "]";
	}
}
