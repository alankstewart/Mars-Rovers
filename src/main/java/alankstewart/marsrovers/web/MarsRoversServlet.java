package alankstewart.marsrovers.web;

import alankstewart.marsrovers.MarsRovers;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Files;

/**
 * Created by alanstewart on 4/03/15.
 */
@WebServlet("/upload")
@MultipartConfig
public class MarsRoversServlet extends HttpServlet {

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        Part filePart = req.getPart("inputFile");
        String fileName = filePart.getSubmittedFileName() + "." + System.nanoTime();
        File tempFile = Files.createTempFile(fileName, null).toFile();
        tempFile.deleteOnExit();
        try (InputStream fileContent = filePart.getInputStream();
             OutputStream outputStream = new FileOutputStream(tempFile)) {
            int read;
            final byte[] bytes = new byte[1024];
            while ((read = fileContent.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        }
        new MarsRovers().loadInputDataAndRun(tempFile, resp.getWriter());
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().flush();
    }
}