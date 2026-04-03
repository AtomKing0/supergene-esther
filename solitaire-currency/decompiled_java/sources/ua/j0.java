package ua;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ua.q0;

/* JADX INFO: compiled from: NioSystemFileSystem.kt */
/* JADX INFO: loaded from: classes5.dex */
@IgnoreJRERequirement
public final class j0 extends t {
    private final Long u(FileTime fileTime) {
        Long lValueOf = Long.valueOf(fileTime.toMillis());
        if (lValueOf.longValue() != 0) {
            return lValueOf;
        }
        return null;
    }

    @Override // ua.t, ua.j
    public void c(@NotNull q0 source, @NotNull q0 target) throws IOException {
        kotlin.jvm.internal.t.i(source, "source");
        kotlin.jvm.internal.t.i(target, "target");
        try {
            Files.move(source.l(), target.l(), StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
        } catch (UnsupportedOperationException unused) {
            throw new IOException("atomic move not supported");
        } catch (NoSuchFileException e10) {
            throw new FileNotFoundException(e10.getMessage());
        }
    }

    @Override // ua.t, ua.j
    @Nullable
    public i m(@NotNull q0 path) {
        kotlin.jvm.internal.t.i(path, "path");
        Path pathL = path.l();
        try {
            BasicFileAttributes attributes = Files.readAttributes(pathL, (Class<BasicFileAttributes>) BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
            Path symbolicLink = attributes.isSymbolicLink() ? Files.readSymbolicLink(pathL) : null;
            boolean zIsRegularFile = attributes.isRegularFile();
            boolean zIsDirectory = attributes.isDirectory();
            q0 q0VarF = symbolicLink != null ? q0.a.f(q0.f34806b, symbolicLink, false, 1, null) : null;
            Long lValueOf = Long.valueOf(attributes.size());
            FileTime fileTimeCreationTime = attributes.creationTime();
            Long lU = fileTimeCreationTime != null ? u(fileTimeCreationTime) : null;
            FileTime fileTimeLastModifiedTime = attributes.lastModifiedTime();
            Long lU2 = fileTimeLastModifiedTime != null ? u(fileTimeLastModifiedTime) : null;
            FileTime fileTimeLastAccessTime = attributes.lastAccessTime();
            return new i(zIsRegularFile, zIsDirectory, q0VarF, lValueOf, lU, lU2, fileTimeLastAccessTime != null ? u(fileTimeLastAccessTime) : null, null, 128, null);
        } catch (NoSuchFileException | FileSystemException unused) {
            return null;
        }
    }

    @Override // ua.t
    @NotNull
    public String toString() {
        return "NioSystemFileSystem";
    }
}
