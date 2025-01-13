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
//import com.example.qrcodescanner.Models.bankModel;
//import com.example.qrcodescanner.R;
//
//import java.util.ArrayList;
//
//public class driverbankAdapter extends RecyclerView.Adapter<driverbankAdapter.ViewHolder> {
//
//    ArrayList<bankModel> driver_bank_list=new ArrayList<>();
//
//
//
//    public static class ViewHolder extends RecyclerView.ViewHolder {
//        private final TextView agent_id;
//        private final TextView driver_name;
//        private final TextView mobile_no;
//        private final TextView bank_name;
//        private final TextView account_no;
//        private final TextView ifsc_code;
//        private final TextView upi_id;
//        private final ImageView sync_status;
//
//        public ViewHolder(View view) {
//            super(view);
//            // Define click listener for the ViewHolder's View
//
//            agent_id= (TextView) view.findViewById(R.id.bank_rv_agent_id);
//            driver_name = (TextView) view.findViewById(R.id.bank_rv_account_name);
//            mobile_no = (TextView) view.findViewById(R.id.bank_rv_mobile_no);
//            bank_name = (TextView) view.findViewById(R.id.bank_rv_name);
//            account_no = (TextView) view.findViewById(R.id.bank_rv_account_no);
//            ifsc_code= (TextView) view.findViewById(R.id.bank_rv_ifsc_code);
//            upi_id= (TextView) view.findViewById(R.id.bank_rv_upi_id);
//            sync_status = view.findViewById(R.id.bank_sync_status_img);
//
//
//
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
//        public TextView getBank_name() {
//            return bank_name;
//        }
//
//        public TextView getAccount_no() {
//            return account_no;
//        }
//
//        public TextView getIfsc_code() {
//            return ifsc_code;
//        }
//
//        public TextView getUpi_id() {
//            return upi_id;
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
//    public driverbankAdapter(ArrayList<bankModel> driver_bank_list)
//    {
//       this.driver_bank_list = driver_bank_list;
//    }
//
//    // Create new views (invoked by the layout manager)
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
//        // Create a new view, which defines the UI of the list item
//        View view = LayoutInflater.from(viewGroup.getContext())
//                .inflate(R.layout.driver_bank_data_rv_items, viewGroup, false);
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
//        bankModel current=driver_bank_list.get(position);
//
//        viewHolder.getAgent_id().setText("Agent Id - "+current.getAgent_id());
//        viewHolder.getDriver_name().setText("Driver Name - "+current.getDriver_name());
//        viewHolder.getMobile_no().setText("Mobile No. - "+current.getMobile_no());
//        viewHolder.getBank_name().setText("Bank - "+current.getBank_name());
//        viewHolder.getAccount_no().setText("Account no. - "+current.getAccount_no());
//        viewHolder.getIfsc_code().setText("IFSC - "+current.getBank_ifsc());
//        viewHolder.getUpi_id().setText("UPI ID - "+current.getBank_upi_id());
//
//
//
////        viewHolder.getAgent_id().setVisibility(current.getAgent_id().equalsIgnoreCase("")?View.GONE:View.VISIBLE);
////        viewHolder.getMobile_no().setGravity(current.getAgent_id().equalsIgnoreCase("") && !(current.getMobile_no().equalsIgnoreCase(""))? Gravity.LEFT :Gravity.RIGHT);
////        viewHolder.getMobile_no().setVisibility(current.getMobile_no().equalsIgnoreCase("")?View.GONE:View.VISIBLE);
//         viewHolder.getUpi_id().setVisibility(current.getBank_upi_id().equalsIgnoreCase("")?View.GONE:View.VISIBLE);
//
//
//        viewHolder.getSync_status().setImageResource((current.getIs_sync().equalsIgnoreCase("false") ? R.drawable.ic_baseline_check_24 : R.drawable.ic_baseline_commit_all_24));
//
//
//    }
//
//    // Return the size of your dataset (invoked by the layout manager)
//    @Override
//    public int getItemCount() {
//        return driver_bank_list.size();
//    }
//}
