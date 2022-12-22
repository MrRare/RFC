package com.application;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class Utility {

	// Taken From org.apache.commons.io.FileUtils
    public static boolean contentEquals(final File file1, final File file2) throws IOException {
        if (file1 == null && file2 == null) {
            return true;
        }
        if (file1 == null ^ file2 == null) {
            return false;
        }
        final boolean file1Exists = file1.exists();
        if (file1Exists != file2.exists()) {
            return false;
        }

        if (!file1Exists) {
            // two not existing files are equal
            return true;
        }

        if (file1.isDirectory() || file2.isDirectory()) {
            // don't want to compare directory contents
            throw new IOException("Can't compare directories, only files");
        }

        if (file1.length() != file2.length()) {
            // lengths differ, cannot be equal
            return false;
        }

        if (file1.getCanonicalFile().equals(file2.getCanonicalFile())) {
            // same file
            return true;
        }

        try (InputStream input1 = new FileInputStream(file1);
             InputStream input2 = new FileInputStream(file2)) {
            return contentEquals(input1, input2);
        }
    }

    // These methods are taken from org.apache.commons.io.IOUtils
    public static boolean contentEquals(final InputStream input1, final InputStream input2)
            throws IOException {
        if (input1 == input2) {
            return true;
        }
        if (input1 == null ^ input2 == null) {
            return false;
        }
        final BufferedInputStream bufferedInput1 = buffer(input1);
        final BufferedInputStream bufferedInput2 = buffer(input2);
        int ch = bufferedInput1.read();
        while (ch != -1) {
            final int ch2 = bufferedInput2.read();
            if (ch != ch2) {
                return false;
            }
            ch = bufferedInput1.read();
        }
        return bufferedInput2.read() == -1;
    }

    public static BufferedInputStream buffer(final InputStream inputStream) {
        // reject null early on rather than waiting for IO operation to fail
        // not checked by BufferedInputStream
        Objects.requireNonNull(inputStream, "inputStream");
        return inputStream instanceof BufferedInputStream ?
                (BufferedInputStream) inputStream : new BufferedInputStream(inputStream);
    }

}
