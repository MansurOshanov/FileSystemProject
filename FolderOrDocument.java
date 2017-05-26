/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

/**
 *
 * @author Mansur Oshanov
 */
public abstract class FolderOrDocument implements Comparable<FolderOrDocument> {

    private String name;
    private Folder parent;

    protected FolderOrDocument(String name, Folder parent) {
        this.name = name;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public Folder getParent() {
        return parent;
    }

    public int compareTo(FolderOrDocument other) {
        return this.name.compareTo(other.getName());
    }

    public abstract boolean isFolder();

}
