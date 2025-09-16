package impl;

import interfaces.Cabinet;
import interfaces.Folder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CabinetImpl implements Cabinet {
    private List<Folder> folders = new ArrayList<>();

    public CabinetImpl(List<Folder> folders) {
        this.folders = folders;
    }

    @Override
    public Optional<Folder> findFolderByName(String name) {
        return this.folders.stream().filter(f -> f.getName().equals(name)).findFirst();
    }

    @Override
    public List<Folder> findFoldersBySize(String size) {
        return this.folders.stream().filter(f -> f.getSize().equals(size)).collect(Collectors.toList());
    }

    @Override
    public int count() {
        return this.folders.size();
    }
}
