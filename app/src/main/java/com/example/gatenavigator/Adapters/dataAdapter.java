//package com.example.gatenavigator.Adapters;
//
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.qrcodescanner.Models.dataModel;
//import com.example.qrcodescanner.R;
//
//import java.util.ArrayList;
//
//public class dataAdapter extends RecyclerView.Adapter<dataAdapter.ViewHolder> {
//
//  ArrayList<dataModel> data_list=new ArrayList<>();
//    String className;
//
//    /**
//     * Provide a reference to the type of views that you are using
//     * (custom ViewHolder).
//     */
//    public static class ViewHolder extends RecyclerView.ViewHolder {
//        private final TextView id;
//        private final TextView timestamp;
////        private final TextView exit_timestamp;
//        private final TextView total_bookings;
//
//        private final ImageView sync_status;
//
//        public ViewHolder(View view) {
//            super(view);
//            // Define click listener for the ViewHolder's View
//
//             id = (TextView) view.findViewById(R.id.data_rv_id);
//             timestamp = (TextView) view.findViewById(R.id.data_rv_timestamp);
////            gate = (TextView) view.findViewById(R.id.data_rv_exit_timestamp);
//             sync_status = (ImageView) view.findViewById(R.id.sync_status_img);
//            total_bookings = (TextView) view.findViewById(R.id.data_rv_total_bookings);
//
//        }
//
//        public TextView getId() {
//            return id;
//        }
//
//        public TextView gettimestamp() {
//            return timestamp;
//        }
//
////        public TextView getExit_timestamp() {
////            return exit_timestamp;
////        }
//
//        public ImageView getSync_status() {
//            return sync_status;
//        }
//    }
//
//
//    public dataAdapter(ArrayList<dataModel> data_list,String className) {
//
//        this.data_list=data_list;
//        this.className=className;
//    }
//
//    // Create new views (invoked by the layout manager)
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
//        // Create a new view, which defines the UI of the list item
//        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.qr_data_rv_items, viewGroup, false);
//
//        return new ViewHolder(view);
//    }
//
//    // Replace the contents of a view (invoked by the layout manager)
//    @Override
//    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
//
//        dataModel current=data_list.get(position);
//
//        // Get element from your dataset at this position and replace the
//        // contents of the view with that element
//        viewHolder.getId().setText("Id - "+current.getId());
//
//
////        viewHolder.timestamp.setText(current.getGate().substring(0,1).toUpperCase()+current.getGate().substring(1)+" Time - "+current.getTimestamp());
//        viewHolder.timestamp.setText("Timestamp - "+current.getTimestamp());
////        viewHolder.exit_timestamp.setText("Exit Time - "+current.getExit_timestamp());
//
////        viewHolder.exit_timestamp.setVisibility((current.getExit_timestamp().equalsIgnoreCase("") || current.getExit_timestamp()==null ? View.GONE:View.VISIBLE));
//
//        if(className.equalsIgnoreCase("MainActivity"))
//            viewHolder.getSync_status().setVisibility(View.GONE);
//        else {
//            viewHolder.getSync_status().setVisibility(View.VISIBLE);
//            viewHolder.getSync_status().setImageResource((current.getIs_sync().equalsIgnoreCase("false") ? R.drawable.ic_baseline_check_24 : R.drawable.ic_baseline_commit_all_24));
//        }
//
//        viewHolder.total_bookings.setText("Total Bookings - "+current.getId().substring(current.getId().lastIndexOf("_")+1));
//
//    }
//
//    // Return the size of your dataset (invoked by the layout manager)
//    @Override
//    public int getItemCount() {
//        return data_list.size();
//    }
//}
//
