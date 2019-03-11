package com.hacra.nclms.modules.library.entity;

import com.hacra.nclms.common.base.BaseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 第三方库
 *
 * @author Hacra
 * @version 1.0
 * @date 2019-03-06 14:44
 */
public class Library extends BaseEntity<Library> {

    private static final long serialVersionUID = 1L;
    private String name;
    private String version;
    private String url;
    private List<Library> libraryList;

    public Library() {
        super();
    }

    public Library(String id) {
        super(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Library> getLibraryList() {
        return libraryList;
    }

    public void setLibraryList(List<Library> libraryList) {
        this.libraryList = libraryList;
    }

    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", url='" + url + '\'' +
                ", libraryList=" + libraryList +
                '}';
    }
}
