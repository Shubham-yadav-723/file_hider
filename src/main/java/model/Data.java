package model;

public class Data {
    private int id;
    private String path;
    private String filename;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Data(int id, String path, String filename) {
        this.id = id;
        this.path = path;
        this.filename = filename;
    }

    private String email;

    public Data(int id, String path, String filename, String email) {
        this.id = id;
        this.path = path;
        this.filename = filename;
        this.email = email;
    }
}
