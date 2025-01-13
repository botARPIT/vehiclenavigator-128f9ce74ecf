//package com.example.gatenavigator.Adapters;
//
//
//import android.view.Gravity;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.qrcodescanner.Models.driverModel;
//import com.example.qrcodescanner.R;
//
//import java.util.ArrayList;
//
//public class driverAdapter extends RecyclerView.Adapter<driverAdapter.ViewHolder> {
//
//    ArrayList<driverModel> marked_driver_list=new ArrayList<>();
//
//
//
//    public static class ViewHolder extends RecyclerView.ViewHolder {
//private final TextView timestamp;
//        private final TextView agent_id;
//        private final TextView driver_name;
//        private final TextView mobile_no;
//        private final TextView vehicle_type;
//        private final TextView vehicle_no;
//        private final ImageView sync_status;
//
//        public ViewHolder(View view) {
//            super(view);
//            // Define click listener for the ViewHolder's View
//
//            timestamp = (TextView) view.findViewById(R.id.driver_rv_timestamp);
//            agent_id= (TextView) view.findViewById(R.id.driver_rv_agent_id);
//            driver_name = (TextView) view.findViewById(R.id.driver_rv_name);
//            mobile_no = (TextView) view.findViewById(R.id.driver_rv_mobile_no);
//            vehicle_type = (TextView) view.findViewById(R.id.driver_rv_vehicle_type);
//            vehicle_no = (TextView) view.findViewById(R.id.driver_rv_vehicle_no);
//            sync_status = view.findViewById(R.id.driver_sync_status_img);
//
//
//
//        }
//
//        public TextView getTimestamp() {
//            return timestamp;
//        }
//
//        public TextView getAgent_id() {
//            return agent_id;
//        }
//
//        public TextView getDriver_name() {
//            return driver_name;
//        }
//
//        public TextView getMobile_no() {
//            return mobile_no;
//        }
//
//        public TextView getVehicle_type() {
//            return vehicle_type;
//        }
//
//        public TextView getVehicle_no() {
//            return vehicle_no;
//        }
//
//        public ImageView getSync_status() {
//            return sync_status;
//        }
//    }
//
//
//
//
//
//    public driverAdapter(ArrayList<driverModel> marked_driver_list)
//    {
//       this.marked_driver_list = marked_driver_list;
//    }
//
//    // Create new views (invoked by the layout manager)
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
//        // Create a new view, which defines the UI of the list item
//        View view = LayoutInflater.from(viewGroup.getContext())
//                .inflate(R.layout.driver_data_rv_items, viewGroup, false);
//
//        return new ViewHolder(view);
//    }
//
//    // Replace the contents of a view (invoked by the layout manager)
//    @Override
//    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
//
//        // Get element from your dataset at this position and replace the
//        // contents of the view with that element
//        driverModel current=marked_driver_list.get(position);
//
//        viewHolder.getTimestamp().setText("Timestamp - "+current.getDate_time());
//        viewHolder.getAgent_id().setText("Agent Id - "+current.getAgent_id());
//        viewHolder.getVehicle_type().setText("Vehicle Type - "+current.getVehicle_type());
//        viewHolder.getVehicle_no().setText("Vehicle No. - "+current.getVehicle_no());
//        viewHolder.getDriver_name().setText("Driver Name - "+current.getDriver_name());
//        viewHolder.getMobile_no().setText("Mobile No. - "+current.getMobile_no());
//
//        viewHolder.getAgent_id().setVisibility(current.getAgent_id().equalsIgnoreCase("")?View.GONE:View.VISIBLE);
//        viewHolder.getMobile_no().setGravity(current.getAgent_id().equalsIgnoreCase("") && !(current.getMobile_no().equalsIgnoreCase(""))? Gravity.LEFT :Gravity.RIGHT);
//        viewHolder.getMobile_no().setVisibility(current.getMobile_no().equalsIgnoreCase("")?View.GONE:View.VISIBLE);
//        viewHolder.getDriver_name().setVisibility(current.getDriver_name().equalsIgnoreCase("")?View.GONE:View.VISIBLE);
//        viewHolder.getVehicle_no().setVisibility(current.getVehicle_no().equalsIgnoreCase("")?View.GONE:View.VISIBLE);
//
//        viewHolder.getSync_status().setImageResource((current.getIs_sync().equalsIgnoreCase("false") ? R.drawable.ic_baseline_check_24 : R.drawable.ic_baseline_commit_all_24));
//
//
//    }
//
//    // Return the size of your dataset (invoked by the layout manager)
//    @Override
//    public int getItemCount() {
//        return marked_driver_list.size();
//    }
//}
