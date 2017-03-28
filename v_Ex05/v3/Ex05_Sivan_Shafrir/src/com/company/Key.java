package com.company;

import java.io.Serializable;

/**
 * Created by hackeru on 3/22/2017.
 */
public interface Key<T> extends Serializable {
    T getKey();
}
