package impl;

import interfaces.Cabinet;
import interfaces.Folder;
import interfaces.MultiFolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CabinetImpl implements Cabinet {
    private final List<Folder> folders;

    public CabinetImpl(List<Folder> folders) {
        this.folders = folders;
    }

    private List<Folder> flatten(Folder folder) {
        List<Folder> all = new ArrayList<>();
        all.add(folder);

        if (folder instanceof MultiFolder multi) {
            for (var child : multi.getFolders()) {
                all.addAll(flatten(child));
            }
        }

        return all;
    }

    private List<Folder> getAllFolders() {
        List<Folder> result = new ArrayList<>();
        for (var folder : folders) {
            result.addAll(flatten(folder));
        }
        return result;
    }

    @Override
    public Optional<Folder> findFolderByName(String name) {
        return getAllFolders().stream()
                .filter(f -> f.getName().equals(name))
                .findFirst();
    }

    @Override
    public List<Folder> findFoldersBySize(String size) {
        return getAllFolders().stream()
                .filter(f -> f.getSize().equals(size))
                .collect(Collectors.toList());
    }

    @Override
    public int count() {
        return this.folders.size();
    }
}
