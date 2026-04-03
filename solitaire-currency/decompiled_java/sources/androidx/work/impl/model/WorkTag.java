package androidx.work.impl.model;

import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import io.sentry.protocol.ViewHierarchyNode;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: WorkTag.kt */
/* JADX INFO: loaded from: classes2.dex */
@Entity(foreignKeys = {@ForeignKey(childColumns = {"work_spec_id"}, entity = WorkSpec.class, onDelete = 5, onUpdate = 5, parentColumns = {"id"})}, indices = {@Index({"work_spec_id"})}, primaryKeys = {ViewHierarchyNode.JsonKeys.TAG, "work_spec_id"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class WorkTag {

    @ColumnInfo(name = ViewHierarchyNode.JsonKeys.TAG)
    @NotNull
    private final String tag;

    @ColumnInfo(name = "work_spec_id")
    @NotNull
    private final String workSpecId;

    public WorkTag(@NotNull String tag, @NotNull String workSpecId) {
        t.i(tag, "tag");
        t.i(workSpecId, "workSpecId");
        this.tag = tag;
        this.workSpecId = workSpecId;
    }

    @NotNull
    public final String getTag() {
        return this.tag;
    }

    @NotNull
    public final String getWorkSpecId() {
        return this.workSpecId;
    }
}
