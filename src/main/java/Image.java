import com.fasterxml.jackson.annotation.JsonProperty;

public class Image {
    private String copyright;
    private String date;
    private String hdurl;
    private String explanation;
    private String mediaType;
    private String service_version;
    private String title;
    private String url;

public Image(
            @JsonProperty("copyright")String copyright,
            @JsonProperty("date")String date,
            @JsonProperty("hdurl")String hdurl,
            @JsonProperty("explanation")String explanation,
            @JsonProperty("media_type")String mediaType,
            @JsonProperty("service_version")String service_version,
            @JsonProperty("Title")String title,
            @JsonProperty("url")String url) {
    this.copyright = copyright;
    this.date = date;
    this.hdurl = hdurl;
    this.explanation = explanation;
    this.mediaType = mediaType;
    this.service_version = service_version;
    this.title = title;
    this.url = url;
}

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getService_version() {
        return service_version;
    }

    public void setService_version(String service_version) {
        this.service_version = service_version;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return  "Game\n{" +
                "\n copyright " + copyright +
                "\ndate  " + date +
                "\n hdurl " + hdurl +
                "\n explanation " + explanation +
                "\n mediaType " + mediaType +
                "\n serviceVersion " + service_version +
                "\n title " + title +
                "\n url " + url +
                '}';
    }
}
