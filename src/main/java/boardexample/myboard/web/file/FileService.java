package boardexample.myboard.web.file;

import boardexample.myboard.domain.child.Child;
import boardexample.myboard.domain.child.ChildRepository;
import boardexample.myboard.domain.file.FileEntity;
import boardexample.myboard.domain.file.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class FileService {
    @Value("${file.dir}")
    private String fileDir;

    private final FileRepository fileRepository;

    private final ChildRepository childRepository;

    public Long saveFile(MultipartFile files, Long childId) throws IOException {
        if (files.isEmpty()){
            return Long.valueOf(0);
        }
        Child child = childRepository.findById(childId).orElseThrow(()->new IllegalStateException("해당 자식이 없어요"));

        String origName = files.getOriginalFilename();

        String uuid = UUID.randomUUID().toString();

        String extension = origName.substring(origName.lastIndexOf("."));

        String savedName = uuid + extension;

        String savedPath = fileDir + savedName;

        FileEntity file = FileEntity.builder().orgNm(origName)
                .savedNm(savedName).savedPath(savedPath).build();

        files.transferTo(new File(savedPath));

        FileEntity save = fileRepository.save(file);
        return save.getId();
    }

}
