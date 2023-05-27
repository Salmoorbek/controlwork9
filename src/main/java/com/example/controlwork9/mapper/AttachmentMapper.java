package com.example.controlwork9.mapper;

import com.example.controlwork9.dto.AttachmentDto;
import com.example.controlwork9.entity.Attachment;
import org.springframework.stereotype.Component;

@Component
public class AttachmentMapper {
    public AttachmentDto from(Attachment attachment) {
        return AttachmentDto.builder()
                .filename(attachment.getFilename())
                .filepath(attachment.getFilepath())
                .build();
    }
}
