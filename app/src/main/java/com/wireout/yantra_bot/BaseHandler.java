package com.wireout.yantra_bot;

import android.app.Activity;
import android.os.Bundle;

import java.util.List;

public interface BaseHandler {
    List<String> getQuickResponseList();
    Bundle getBundledParameters();
}
