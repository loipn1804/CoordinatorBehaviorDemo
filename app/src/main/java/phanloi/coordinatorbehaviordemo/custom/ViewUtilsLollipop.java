package phanloi.coordinatorbehaviordemo.custom;

import android.view.View;
import android.view.ViewOutlineProvider;

/**
 * Copyright (c) 2017, VNG Corp. All rights reserved.
 *
 * @author Lio <loipn@vng.com.vn>
 * @version 1.0
 * @since June 02, 2017
 */

public class ViewUtilsLollipop {

    static void setBoundsViewOutlineProvider(View view) {
        view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
    }

}
