package model;

public class Photo {
	private Long id_gruppo;
	private String url_photo;


	public Photo() {
	}
	
	public Photo(Long id_gruppo) {
		this.id_gruppo = id_gruppo;
	}

	public Photo(Long id_gruppo, String url_photo) {
		this.id_gruppo = id_gruppo;
		this.url_photo = url_photo;
	}

	public String getUrl_photo() {
		return this.url_photo;
	}

	public void setUrl_photo(String Url) {
		this.url_photo = Url;
	}

	public Long getId() {
		return this.id_gruppo;
	}

	public void setId(Long i) {
		this.id_gruppo = i;
	}

}
