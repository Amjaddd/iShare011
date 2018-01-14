package com.example.husam_pc.myishare;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by arabi_000 on 1/11/2018.
 */

public class AdapterShowContacts extends RecyclerView.Adapter<AdapterShowContacts.contactsViewHolder> {
    //private List<ContactsSelectionModel> contactList ;
    private List<ModelContactsList> contactList;
    private Context context;

    AdapterShowContacts(Context context, List<ModelContactsList> list){
        this.context = context;
        this.contactList=list;
        // selectedContacts = null;
    }

    @Override
    public contactsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =  LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.view_all_contact,parent,false);

        return new contactsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(contactsViewHolder holder, int position) {

        holder.userName.setText(contactList.get(position).getUserNameId());
        holder.userIcon.setImageResource(contactList.get(position).getUserIconId());
        holder.userPoneNum.setText(contactList.get(position).getPhoneNumber());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(context, MainChat.class);
                    // intent.putExtra("contactName",recyclerView.getChildItemId(v));
                    context.startActivity(intent);
                
            }
        });


    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

/*    @Override
    public int getCount() {
        return contactList.size();
    }
    @Override
    public Object getItem(int position) {
        return contactList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }
* */

   /*
   *  @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final AdapterShowContacts.ViewHolder holder;
        LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            if (vi != null) {
                convertView = vi.inflate(R.layout.view_all_contact, null);
            }
            holder = createViewHolder(convertView);
            if (convertView != null) {
                convertView.setTag(holder);
            }
        } else {
            holder = (AdapterShowContacts.ViewHolder) convertView.getTag();
        }

        holder.number.setText(contactList.get(position).getContact());
        holder.contactPic.setImageResource(R.mipmap.ic_launcher_round);

        return convertView;
    }
    private AdapterShowContacts.ViewHolder createViewHolder(View v) {
        AdapterShowContacts.ViewHolder holder = new AdapterShowContacts.ViewHolder();
        holder.number = (TextView) v.findViewById(R.id.contactsView);
        holder.contactPic = (ImageView) v.findViewById(R.id.contactPic);
        return holder;
    }
*/

    class contactsViewHolder extends RecyclerView.ViewHolder{

        ImageView userIcon;
        TextView userName;
        TextView userPoneNum;
        RelativeLayout relativeLayout;

        public contactsViewHolder(View itemView) {
            super(itemView);
            userIcon = itemView.findViewById(R.id.contactPic);
            userName = itemView.findViewById(R.id.contactsView);
            userPoneNum= itemView.findViewById(R.id.numberView);
            relativeLayout=itemView.findViewById(R.id.contactbar);
        }
    }

    /*
    private static class ViewHolder {
        public TextView number;
        public ImageView contactPic;
    }
     */
}