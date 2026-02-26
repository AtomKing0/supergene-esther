package io.sentry;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: SynchronizedCollection.java */
/* JADX INFO: loaded from: classes5.dex */
class s8<E> implements Collection<E>, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Collection<E> f28225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.sentry.util.a f28226b;

    s8(Collection<E> collection) {
        if (collection == null) {
            throw new NullPointerException("Collection must not be null.");
        }
        this.f28225a = collection;
        this.f28226b = new io.sentry.util.a();
    }

    protected Collection<E> a() {
        return this.f28225a;
    }

    @Override // java.util.Collection
    public boolean add(E e10) {
        k1 k1VarA = this.f28226b.a();
        try {
            boolean zAdd = a().add(e10);
            if (k1VarA != null) {
                k1VarA.close();
            }
            return zAdd;
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        k1 k1VarA = this.f28226b.a();
        try {
            boolean zAddAll = a().addAll(collection);
            if (k1VarA != null) {
                k1VarA.close();
            }
            return zAddAll;
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // java.util.Collection
    public void clear() {
        k1 k1VarA = this.f28226b.a();
        try {
            a().clear();
            if (k1VarA != null) {
                k1VarA.close();
            }
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        k1 k1VarA = this.f28226b.a();
        try {
            boolean zContains = a().contains(obj);
            if (k1VarA != null) {
                k1VarA.close();
            }
            return zContains;
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        k1 k1VarA = this.f28226b.a();
        try {
            boolean zContainsAll = a().containsAll(collection);
            if (k1VarA != null) {
                k1VarA.close();
            }
            return zContainsAll;
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        k1 k1VarA = this.f28226b.a();
        try {
            boolean zIsEmpty = a().isEmpty();
            if (k1VarA != null) {
                k1VarA.close();
            }
            return zIsEmpty;
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return a().iterator();
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        k1 k1VarA = this.f28226b.a();
        try {
            boolean zRemove = a().remove(obj);
            if (k1VarA != null) {
                k1VarA.close();
            }
            return zRemove;
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        k1 k1VarA = this.f28226b.a();
        try {
            boolean zRemoveAll = a().removeAll(collection);
            if (k1VarA != null) {
                k1VarA.close();
            }
            return zRemoveAll;
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        k1 k1VarA = this.f28226b.a();
        try {
            boolean zRetainAll = a().retainAll(collection);
            if (k1VarA != null) {
                k1VarA.close();
            }
            return zRetainAll;
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // java.util.Collection
    public int size() {
        k1 k1VarA = this.f28226b.a();
        try {
            int size = a().size();
            if (k1VarA != null) {
                k1VarA.close();
            }
            return size;
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public String toString() {
        k1 k1VarA = this.f28226b.a();
        try {
            String string = a().toString();
            if (k1VarA != null) {
                k1VarA.close();
            }
            return string;
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
