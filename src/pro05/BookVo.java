package pro05;

public class BookVo {
	private int id;
	private String title;
	private String pubs;
	private String pubDate;
	private String authorName;
	private String stateCode = "1";

	BookVo() {
	}

	BookVo(String title, String pubs, String pubDate, String authorName, String stateCode) {
		this.title = title;
		this.pubs = pubs;
		this.pubDate = pubDate;
		this.authorName = authorName;
		this.stateCode = stateCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPubs() {
		return pubs;
	}

	public void setPubs(String pubs) {
		this.pubs = pubs;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	@Override
	public String toString() {
		return "BookVo [id=" + id + ", title=" + title + ", pubs=" + pubs + ", pubDate=" + pubDate + ", authorName="
				+ authorName + ", stateCode=" + stateCode + "]";
	}

}
