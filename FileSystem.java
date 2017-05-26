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
public class FileSystem implements FileSystemInterface {

    /**
     * Executes the given command on the file system. See the instructions for
     * details about how each individual command should to handled.
     *
     * @param cmd - the command object to execute
     */
    private LLStack<Command> history;
    private Folder root;
    private Folder currentFolder;

    public FileSystem(String rootName) {
        history = new LLStack<>();
        root = new Folder(rootName, null);
        currentFolder = root;
    }

    public void doCommand(Command cmd) {
        switch (cmd.getCommandCode()) {
            case 1:
                if (!currentFolder.isNameInFolder(cmd.getName())) {
                    Folder temp = new Folder(cmd.getName(), currentFolder);
                    currentFolder.getContents().enqueue(temp);
                    history.push(cmd);
                }

                break;
            case 2:
                if (!currentFolder.isNameInFolder(cmd.getName())) {
                    Document temp = new Document(cmd.getName(), currentFolder);
                    currentFolder.getContents().enqueue(temp);
                    history.push(cmd);
                }

                break;
            case 3:
                if (currentFolder.isNameInFolder(cmd.getName())) {

                    for (int i = 0; i < currentFolder.getContents().getSize(); i++) {
                        FolderOrDocument test = null;
                        try {
                            test = currentFolder.getContents().dequeue();
                        } catch (Exception ex) {
                            System.out.println("No folder or Document");
                        }
                        if (!cmd.getName().equals(test.getName())) {
                            currentFolder.getContents().enqueue(test);
                        } else {
                            if (!test.isFolder()) {
                                currentFolder.getContents().enqueue(test);
                            } else {
                                Folder temp = (Folder) test;
                                if (temp.getContents().getSize() != 0) {
                                    currentFolder.getContents().enqueue(test);
                                } else {
                                    history.push(cmd);
                                }
                            }
                        }
                    }
                }
                break;

            case 4:
                if (currentFolder.isNameInFolder(cmd.getName())) {
                    for (int i = 0; i < currentFolder.getContents().getSize(); i++) {
                        FolderOrDocument test = null;
                        try {
                            test = currentFolder.getContents().dequeue();
                        } catch (Exception ex) {
                            System.out.println("No folder or Document");
                        }
                        if (!cmd.getName().equals(test.getName())) {
                            currentFolder.getContents().enqueue(test);
                        } else {
                            if (test.isFolder()) {
                                currentFolder.getContents().enqueue(test);
                            } else {
                                history.push(cmd);
                            }

                        }
                    }
                }
                break;

            case 5:
                if (currentFolder != root) {
                    cmd.setName(currentFolder.getName());
                    currentFolder = currentFolder.getParent();
                    history.push(cmd);
                }
                break;
            case 6:
                if (currentFolder.isNameInFolder(cmd.getName())) {
                    for (int i = 0; i < currentFolder.getContents().getSize(); i++) {
                        try {
                            FolderOrDocument test = currentFolder.getContents().dequeue();
                            currentFolder.getContents().enqueue(test);
                            if (cmd.getName().equals(test.getName()) && test.isFolder()) {
                                currentFolder = (Folder) test;
                                history.push(cmd);

                            }
                        } catch (Exception ex) {
                            System.out.println("No folder or Document");
                        }

                    }
                }
                break;
            default:
                System.out.println("Improper command");
                break;
        }
    }

    /**
     * Undoes the last command on the command stack.
     */
    public void undoLastCommand() {

        try {
            Command h = history.pop();
            switch (h.getCommandCode()) {
                
                case 1:
                    
                    if (currentFolder.isNameInFolder(h.getName())) {
                        for (int i = 0; i < currentFolder.getContents().getSize(); i++) {
                            FolderOrDocument test = null;
                            try {
                                test = currentFolder.getContents().dequeue();
                            } catch (Exception ex) {
                                System.out.println("No folder or Document");
                            }
                            if (!h.getName().equals(test.getName()) || !test.isFolder()) {
                                currentFolder.getContents().enqueue(test);
                            } else {

                            }
                        }
                    }
                    break;
                    
                case 2:

                    for (int i = 0; i < currentFolder.getContents().getSize(); i++) {
                        FolderOrDocument test = null;
                        try {
                            test = currentFolder.getContents().dequeue();

                        } catch (Exception ex) {
                            System.out.println("No folder or Document");
                        }
                        if (!h.getName().equals(test.getName()) || test.isFolder()) {
                            currentFolder.getContents().enqueue(test);
                        } else {

                        }
                    }
                    break;

                case 3:

                    Folder temp = new Folder(h.getName(), currentFolder);
                    currentFolder.getContents().enqueue(temp);

                    break;

                case 4:

                    Document doc = new Document(h.getName(), currentFolder);
                    currentFolder.getContents().enqueue(doc);

                    break;

                case 5:

                    for (int i = 0; i < currentFolder.getContents().getSize(); i++) {
                        try {
                            FolderOrDocument test = currentFolder.getContents().dequeue();
                            currentFolder.getContents().enqueue(test);
                            if (h.getName().equals(test.getName()) && test.isFolder()) {
                                currentFolder = (Folder) test;

                            }
                        } catch (Exception ex) {
                            System.out.println("No folder or Document");
                        }

                    }
                    break;

                case 6:
                    
                    if (currentFolder != root) {
                        currentFolder = currentFolder.getParent();

                    }
                    break;
                    
                default:
                    System.out.println("Improper command");
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Empty history");
        }

    }

    ;
/**
 * Prints the names of the folders and documents in the current folder
 */
public void listContents() {
        currentFolder.getContentNames();
    }

    ;

    /**
     * Provides a listing of all documents and folders on your file system, in
     * the form of full pathnames starting from the root. The pathnames will be
     * listed in the queue in the order defined by the rules:
     *
     * 1. If path1 represents a folder which contains the item path2 somewhere
     * down the hierarchy, then path1 < path2
     *
     * 2. If path1 and path2 represent items that are directly inside the same
     * folder, and path1 comes before path2 in lexicographic order, then path1 <
     * path2
     *
     * @return a queue of the pathnames of all items on the file system
     */
    public Queue<String> getAllPaths() {
        return root.getAllPaths();
    }
;
}
