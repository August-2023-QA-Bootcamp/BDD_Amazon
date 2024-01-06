package qa.amazon.bdd.constant;

public enum FileName {

	CONFIG_PROPERTIES("config.properties"),
	SOMETHING_ELSE("something");
	
	private String fileName;
	
	private FileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getFileNameValue() {
		return fileName;
	}
}
