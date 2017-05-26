/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mansur Oshanov
 */
public class Folder extends FolderOrDocument {

    private Queue<FolderOrDocument> contents;

    public Folder(String name, Folder parent) {
        super(name, parent);
        contents = new LLQueue<>();
    }

    public Queue<FolderOrDocument> getContents() {
        return contents;
    }

    /**
     * Use to check if there is an item in this folder with the given name.
     *
     * @param aName the name to check for
     * @return true iff there is a document or folder with aName in this folder
     */
    public boolean isNameInFolder(String aName) {

        Set<String> egFile = new LLSet<>();
        FolderOrDocument temp = null;
        int i = contents.getSize();
        while (i != 0) {
            try {
                temp = contents.dequeue();
                contents.enqueue(temp);
                egFile.add(temp.getName());
                i--;
            } catch (Exception ex) {
                System.out.println("No folder or Document");
            }
        }

        return egFile.contains(aName);
    }

    /**
     * Returns a listing of names (not paths) of all the items in this folder.
     *
     * @return the names of the documents and folders in this folder, sorted by
     * lexicographic order
     */
    public SortedQueue<String> getContentNames() {

        LLSortedQueue<String> alphOrder = new LLSortedQueue<>();
        FolderOrDocument temp = null;
        int i = contents.getSize();
        while (i != 0) {
            try {
                temp = contents.dequeue();
                contents.enqueue(temp);
                alphOrder.insert(temp.getName());
                i--;
            } catch (Exception ex) {
                System.out.println("No folder or Document");
            }
        }
        return alphOrder;
    }

    @Override
    public boolean isFolder() {
        return true;
    }

    // Don't change.... this is used for testing
    /**
     * @return queue of pathnames of all files in the system rooted at the
     * current folder
     */
    public Queue<String> getAllPaths() {
        Queue<String> results = new LLQueue<>();
        results.enqueue(this.getName());
        getAllPaths(getName(), results);
        return results;
    }

    // Don't change.... this is used for testing
    protected void getAllPaths(String prePath, Queue<String> results) {

        SortedQueue<FolderOrDocument> sorted = new LLSortedQueue<>();

        for (int i = 0; i < contents.getSize(); i++) {
            FolderOrDocument fod;
            try {
                fod = contents.dequeue();
                contents.enqueue(fod);
                sorted.insert(fod);
            } catch (Exception e) {
                System.out.println("No folder or document");
            }
        }

        while (sorted.getSize() > 0) {
            try {
                FolderOrDocument fod = sorted.dequeue();
                String fodPath = prePath + "/" + fod.getName();
                results.enqueue(fodPath);
                if (fod.isFolder()) {
                    Folder folder = (Folder) fod;
                    folder.getAllPaths(fodPath, results);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
