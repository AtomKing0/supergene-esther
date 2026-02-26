package androidx.work.impl.model;

import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: WorkName.kt */
/* JADX INFO: loaded from: classes2.dex */
@Entity(foreignKeys = {@ForeignKey(childColumns = {"work_spec_id"}, entity = WorkSpec.class, onDelete = 5, onUpdate = 5, parentColumns = {"id"})}, indices = {@Index({"work_spec_id"})}, primaryKeys = {"name", "work_spec_id"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class WorkName {

    @ColumnInfo(name = "name")
    @NotNull
    private final String name;

    @ColumnInfo(name = "work_spec_id")
    @NotNull
    private final String workSpecId;

    public WorkName(@NotNull String name, @NotNull String workSpecId) {
        t.i(name, "name");
        t.i(workSpecId, "workSpecId");
        this.name = name;
        this.workSpecId = workSpecId;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getWorkSpecId() {
        return this.workSpecId;
    }
}
