package tcc.developer.allef.mygithubasyncktask.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by allef on 21/10/2017.
 */

public class RepositorioGitHub implements Serializable {
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("full_name")
    private String full_name;
    @SerializedName("language")
    private String language;
    @SerializedName("html_url")
    private String html_url;



    public RepositorioGitHub() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }
}
