package alankstewart.marsrovers.web;

import alankstewart.marsrovers.MarsRovers;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 * Created by alanstewart on 4/03/15.
 */
@WebServlet("/upload")
@MultipartConfig
public class MarsRoversServlet extends HttpServlet {

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        var filePart = req.getPart("inputFile");
        var fileName = filePart.getSubmittedFileName() + "." + System.nanoTime();
        var tempFile = Files.createTempFile(fileName, null).toFile();
        tempFile.deleteOnExit();
        try (var fileContent = filePart.getInputStream()) {
            Files.copy(fileContent, tempFile.toPath(), REPLACE_EXISTING);
        }
        new MarsRovers().loadInputDataAndRun(tempFile, resp.getWriter());
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().flush();
    }
}