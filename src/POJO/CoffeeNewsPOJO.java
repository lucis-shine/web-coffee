package POJO;

public class CoffeeNewsPOJO {
    private Integer id;
    private String        picture;
    private String title;
    private String        content;
    private String  addtime;
    private String          isDelete;

    public CoffeeNewsPOJO() {
    }

    public CoffeeNewsPOJO(Integer id, String picture, String title, String content, String addtime, String isDelete) {
        this.id = id;
        this.picture = picture;
        this.title = title;
        this.content = content;
        this.addtime = addtime;
        this.isDelete = isDelete;
    }

    public CoffeeNewsPOJO(Integer id, String picture, String title, String content, String addtime) {
        this.id = id;
        this.picture = picture;
        this.title = title;
        this.content = content;
        this.addtime = addtime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "CoffeeNewsPOJO{" +
                "id=" + id +
                ", picture='" + picture + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", addtime='" + addtime + '\'' +
                ", isDelete='" + isDelete + '\'' +
                '}';
    }
}
