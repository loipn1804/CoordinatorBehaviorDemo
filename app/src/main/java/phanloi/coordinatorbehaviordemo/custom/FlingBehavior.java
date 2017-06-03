package phanloi.coordinatorbehaviordemo.custom;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Copyright (c) 2017, VNG Corp. All rights reserved.
 *
 * @author Lio <loipn@vng.com.vn>
 * @version 1.0
 * @since May 22, 2017
 */

public class FlingBehavior extends CustomAppBarLayout.Behavior {
    private static final int TOP_CHILD_FLING_THRESHOLD = 3;
    private boolean isPositive;

    public FlingBehavior() {
    }

    public FlingBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onNestedFling(CoordinatorLayout coordinatorLayout, CustomAppBarLayout child, View target, float velocityX, float velocityY, boolean consumed) {
//        if (velocityY > 0 && !isPositive || velocityY < 0 && isPositive) {
//            velocityY = velocityY * -5;
//        }
//        if (target instanceof RecyclerView && velocityY < 0) {
//            final RecyclerView recyclerView = (RecyclerView) target;
//            final View firstChild = recyclerView.getChildAt(0);
//            final int childAdapterPosition = recyclerView.getChildAdapterPosition(firstChild);
//            consumed = childAdapterPosition > TOP_CHILD_FLING_THRESHOLD;
//        }
        Log.d("LOI", "before target " + target.getClass().getSimpleName() + " velocity " + velocityY + " consumed " + consumed);
        if (target instanceof RecyclerView) {
            final RecyclerView recyclerView = (RecyclerView) target;
            final int firstChildPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
            Log.d("LOI", "firstChild " + firstChildPosition);
            if (velocityY < 0) {
                if (firstChildPosition == 0) {
                    if (velocityY > 0 && !isPositive || velocityY < 0 && isPositive) {
                        velocityY = velocityY * -10;
                        Log.e("Lio", "velocityY * -10 " + velocityY);
                    }
                    velocityY = -10000;
                    final View firstChild = recyclerView.getChildAt(0);
                    final int childAdapterPosition = recyclerView.getChildAdapterPosition(firstChild);
                    consumed = childAdapterPosition > TOP_CHILD_FLING_THRESHOLD;
                }
            } else {

            }
        }
        Log.d("LOI", "after  target " + target.getClass().getSimpleName() + " velocity " + velocityY + " consumed " + consumed);
        return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed);
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, CustomAppBarLayout child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
        isPositive = dy > 0;
    }
}
