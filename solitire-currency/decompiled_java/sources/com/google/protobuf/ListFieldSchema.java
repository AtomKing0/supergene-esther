package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
@CheckReturnValue
abstract class ListFieldSchema {
    private static final ListFieldSchema FULL_INSTANCE;
    private static final ListFieldSchema LITE_INSTANCE;

    private static final class ListFieldSchemaFull extends ListFieldSchema {
        private static final Class<?> UNMODIFIABLE_LIST_CLASS = Collections.unmodifiableList(Collections.emptyList()).getClass();

        private ListFieldSchemaFull() {
            super();
        }

        static <E> List<E> getList(Object obj, long j10) {
            return (List) UnsafeUtil.getObject(obj, j10);
        }

        @Override // com.google.protobuf.ListFieldSchema
        void makeImmutableListAt(Object obj, long j10) {
            Object objUnmodifiableList;
            List list = (List) UnsafeUtil.getObject(obj, j10);
            if (list instanceof LazyStringList) {
                objUnmodifiableList = ((LazyStringList) list).getUnmodifiableView();
            } else {
                if (UNMODIFIABLE_LIST_CLASS.isAssignableFrom(list.getClass())) {
                    return;
                }
                if ((list instanceof PrimitiveNonBoxingCollection) && (list instanceof Internal.ProtobufList)) {
                    Internal.ProtobufList protobufList = (Internal.ProtobufList) list;
                    if (protobufList.isModifiable()) {
                        protobufList.makeImmutable();
                        return;
                    }
                    return;
                }
                objUnmodifiableList = Collections.unmodifiableList(list);
            }
            UnsafeUtil.putObject(obj, j10, objUnmodifiableList);
        }

        @Override // com.google.protobuf.ListFieldSchema
        <E> void mergeListsAt(Object obj, Object obj2, long j10) {
            List list = getList(obj2, j10);
            List listMutableListAt = mutableListAt(obj, j10, list.size());
            int size = listMutableListAt.size();
            int size2 = list.size();
            if (size > 0 && size2 > 0) {
                listMutableListAt.addAll(list);
            }
            if (size > 0) {
                list = listMutableListAt;
            }
            UnsafeUtil.putObject(obj, j10, list);
        }

        @Override // com.google.protobuf.ListFieldSchema
        <L> List<L> mutableListAt(Object obj, long j10) {
            return mutableListAt(obj, j10, 10);
        }

        private static <L> List<L> mutableListAt(Object obj, long j10, int i10) {
            Object obj2;
            List<L> list = getList(obj, j10);
            if (list.isEmpty()) {
                List<L> lazyStringArrayList = list instanceof LazyStringList ? new LazyStringArrayList(i10) : ((list instanceof PrimitiveNonBoxingCollection) && (list instanceof Internal.ProtobufList)) ? ((Internal.ProtobufList) list).mutableCopyWithCapacity2(i10) : new ArrayList<>(i10);
                UnsafeUtil.putObject(obj, j10, lazyStringArrayList);
                return lazyStringArrayList;
            }
            if (UNMODIFIABLE_LIST_CLASS.isAssignableFrom(list.getClass())) {
                ArrayList arrayList = new ArrayList(list.size() + i10);
                arrayList.addAll(list);
                UnsafeUtil.putObject(obj, j10, arrayList);
                obj2 = arrayList;
            } else {
                if (!(list instanceof UnmodifiableLazyStringList)) {
                    if (!(list instanceof PrimitiveNonBoxingCollection) || !(list instanceof Internal.ProtobufList)) {
                        return list;
                    }
                    Internal.ProtobufList protobufList = (Internal.ProtobufList) list;
                    if (protobufList.isModifiable()) {
                        return list;
                    }
                    Internal.ProtobufList protobufListMutableCopyWithCapacity2 = protobufList.mutableCopyWithCapacity2(list.size() + i10);
                    UnsafeUtil.putObject(obj, j10, protobufListMutableCopyWithCapacity2);
                    return protobufListMutableCopyWithCapacity2;
                }
                LazyStringArrayList lazyStringArrayList2 = new LazyStringArrayList(list.size() + i10);
                lazyStringArrayList2.addAll((UnmodifiableLazyStringList) list);
                UnsafeUtil.putObject(obj, j10, lazyStringArrayList2);
                obj2 = lazyStringArrayList2;
            }
            return (List<L>) obj2;
        }
    }

    private static final class ListFieldSchemaLite extends ListFieldSchema {
        private ListFieldSchemaLite() {
            super();
        }

        static <E> Internal.ProtobufList<E> getProtobufList(Object obj, long j10) {
            return (Internal.ProtobufList) UnsafeUtil.getObject(obj, j10);
        }

        @Override // com.google.protobuf.ListFieldSchema
        void makeImmutableListAt(Object obj, long j10) {
            getProtobufList(obj, j10).makeImmutable();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1 */
        /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r6v1, types: [com.google.protobuf.Internal$ProtobufList, java.util.Collection, java.util.List] */
        /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r6v3 */
        @Override // com.google.protobuf.ListFieldSchema
        <E> void mergeListsAt(Object obj, Object obj2, long j10) {
            Internal.ProtobufList protobufList = getProtobufList(obj, j10);
            ?? protobufList2 = getProtobufList(obj2, j10);
            int size = protobufList.size();
            int size2 = protobufList2.size();
            ?? r02 = protobufList;
            r02 = protobufList;
            if (size > 0 && size2 > 0) {
                boolean zIsModifiable = protobufList.isModifiable();
                ?? MutableCopyWithCapacity2 = protobufList;
                if (!zIsModifiable) {
                    MutableCopyWithCapacity2 = protobufList.mutableCopyWithCapacity2(size2 + size);
                }
                MutableCopyWithCapacity2.addAll(protobufList2);
                r02 = MutableCopyWithCapacity2;
            }
            if (size > 0) {
                protobufList2 = r02;
            }
            UnsafeUtil.putObject(obj, j10, (Object) protobufList2);
        }

        @Override // com.google.protobuf.ListFieldSchema
        <L> List<L> mutableListAt(Object obj, long j10) {
            Internal.ProtobufList protobufList = getProtobufList(obj, j10);
            if (protobufList.isModifiable()) {
                return protobufList;
            }
            int size = protobufList.size();
            Internal.ProtobufList protobufListMutableCopyWithCapacity2 = protobufList.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
            UnsafeUtil.putObject(obj, j10, protobufListMutableCopyWithCapacity2);
            return protobufListMutableCopyWithCapacity2;
        }
    }

    static {
        FULL_INSTANCE = new ListFieldSchemaFull();
        LITE_INSTANCE = new ListFieldSchemaLite();
    }

    private ListFieldSchema() {
    }

    static ListFieldSchema full() {
        return FULL_INSTANCE;
    }

    static ListFieldSchema lite() {
        return LITE_INSTANCE;
    }

    abstract void makeImmutableListAt(Object obj, long j10);

    abstract <L> void mergeListsAt(Object obj, Object obj2, long j10);

    abstract <L> List<L> mutableListAt(Object obj, long j10);
}
