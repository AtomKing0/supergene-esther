package androidx.work.impl.model;

import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Dependency.kt */
/* JADX INFO: loaded from: classes2.dex */
@Entity(foreignKeys = {@ForeignKey(childColumns = {"work_spec_id"}, entity = WorkSpec.class, onDelete = 5, onUpdate = 5, parentColumns = {"id"}), @ForeignKey(childColumns = {"prerequisite_id"}, entity = WorkSpec.class, onDelete = 5, onUpdate = 5, parentColumns = {"id"})}, indices = {@Index({"work_spec_id"}), @Index({"prerequisite_id"})}, primaryKeys = {"work_spec_id", "prerequisite_id"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class Dependency {

    @ColumnInfo(name = "prerequisite_id")
    @NotNull
    private final String prerequisiteId;

    @ColumnInfo(name = "work_spec_id")
    @NotNull
    private final String workSpecId;

    public Dependency(@NotNull String workSpecId, @NotNull String prerequisiteId) {
        t.i(workSpecId, "workSpecId");
        t.i(prerequisiteId, "prerequisiteId");
        this.workSpecId = workSpecId;
        this.prerequisiteId = prerequisiteId;
    }

    @NotNull
    public final String getPrerequisiteId() {
        return this.prerequisiteId;
    }

    @NotNull
    public final String getWorkSpecId() {
        return this.workSpecId;
    }
}
