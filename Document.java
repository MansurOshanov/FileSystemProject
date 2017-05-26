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
public class Document extends FolderOrDocument {

    protected Document(String name, Folder parent) {
        super(name, parent);
    }

    @Override
    public boolean isFolder() {
        return false;
    }

}
