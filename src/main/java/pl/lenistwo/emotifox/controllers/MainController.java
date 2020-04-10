package pl.lenistwo.emotifox.controllers;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@RestController
public class MainController {

    @GetMapping("/download")
    public ResponseEntity<InputStreamResource> get() throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONNECTION, "close");
        headers.add(HttpHeaders.USER_AGENT, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36");
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=recipe.zip");
        return ResponseEntity.ok().contentLength(getFile().contentLength()).headers(headers).body(getFile());
    }

    public InputStreamResource getFile() throws IOException {
        List<String> fe = Arrays.asList("ada.txt", "adam.txt");
        int i = 0;
        byte[] bytess = "If you know how java IO works at lower level, then you will be aware of buffer handling, memory paging and other such concepts. For conventional file I/O, in which user processes issue read() and write() system calls to transfer data, there is almost always one or more copy operations to move the data between these filesystem pages in kernel space and a memory area in user space. This is because there is not usually a one-to-one alignment between filesystem pages and user buffers. There is, however, a special type of I/O operation supported by most operating systems that allows user processes to take maximum advantage of the page-oriented nature of system I/O and completely avoid buffer copies. This is called memory-mapped I/O and we are going to learn few things here around memory-mapped files".getBytes();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
        for (String s : fe) {
            ZipEntry entry = new ZipEntry("a" + ++i + ".txt");
            zipOutputStream.putNextEntry(entry);
            zipOutputStream.write(bytess, 0, bytess.length);
            ZipEntry entry1 = new ZipEntry("ak" + ++i + ".txt");
            zipOutputStream.putNextEntry(entry1);
            zipOutputStream.write(bytess, 0, bytess.length);
        }
        zipOutputStream.close();
        return new InputStreamResource(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
    }
}
