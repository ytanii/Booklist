package ytanii.booklist.model;


import java.util.List;

public record VolumeInfo(
        String title,
        List<String> authors
) {}