package impl;

import interfaces.Folder;
import interfaces.MultiFolder;

import java.util.List;
import java.util.stream.Collectors;

public class MultiFolderImpl implements MultiFolder {
    List<Folder> folders;

    public MultiFolderImpl(List<Folder> folders) {
        this.folders = folders;
    }

    @Override
    public List<Folder> getFolders() {
        return this.folders;
    }

    @Override
    public String getName() {
        return this.folders.stream().map(Folder::getName).collect(Collectors.joining(", "));
    }

    @Override
    public String getSize() {
        return this.folders.stream().map(Folder::getSize).collect(Collectors.joining(", "));
    }
}
