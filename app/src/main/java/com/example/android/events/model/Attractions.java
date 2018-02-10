package com.example.android.events.model;

import java.util.List;

/**
 * Created by melg on 2/10/18.
 */

public class Attractions {

    private ExternalLinks externalLinks;
    private String locale;
    private String url;
    private boolean test;
    private String id;
    private String type;
    private String name;

    public ExternalLinks getExternalLinks() {
        return externalLinks;
    }

    public void setExternalLinks(ExternalLinks externalLinks) {
        this.externalLinks = externalLinks;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean getTest() {
        return test;
    }

    public void setTest(boolean test) {
        this.test = test;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class ExternalLinks {
        private List<Musicbrainz> musicbrainz;
        private List<Instagram> instagram;
        private List<Facebook> facebook;
        private List<Twitter> twitter;
        private List<Youtube> youtube;

        public List<Musicbrainz> getMusicbrainz() {
            return musicbrainz;
        }

        public void setMusicbrainz(List<Musicbrainz> musicbrainz) {
            this.musicbrainz = musicbrainz;
        }

        public List<Instagram> getInstagram() {
            return instagram;
        }

        public void setInstagram(List<Instagram> instagram) {
            this.instagram = instagram;
        }

        public List<Facebook> getFacebook() {
            return facebook;
        }

        public void setFacebook(List<Facebook> facebook) {
            this.facebook = facebook;
        }

        public List<Twitter> getTwitter() {
            return twitter;
        }

        public void setTwitter(List<Twitter> twitter) {
            this.twitter = twitter;
        }

        public List<Youtube> getYoutube() {
            return youtube;
        }

        public void setYoutube(List<Youtube> youtube) {
            this.youtube = youtube;
        }
    }

    public static class Musicbrainz {
        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static class Instagram {
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class Facebook {
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class Twitter {
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class Youtube {
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
