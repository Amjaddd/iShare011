package com.example.husam_pc.myishare;

/**
 * Created by arabi_000 on 1/12/2018.
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Amjad on 12/28/2017.
 */

// Adapter For Group Contacts
public class AdapterShowGroupContacts extends  RecyclerView.Adapter<AdapterShowGroupContacts.groupViewHolder> {
    private List<ModelContactsList> groupList;
    private Context context;
    private List<String> friendsList;

    AdapterShowGroupContacts(Context context, List<ModelContactsList> list){
        this.context = context;
        this.groupList =list;
        // selectedContacts = null;
    }

    @Override
    public groupViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =  LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.view_all_contact_group,parent,false);

        return new groupViewHolder(view);

    }

    @Override
    public void onBindViewHolder(groupViewHolder holder, final int position) {
        holder.userName.setText(groupList.get(position).getUserNameId());
        holder.userIcon.setImageResource(groupList.get(position).getUserIconId());
        holder.userPoneNum.setText(groupList.get(position).getPhoneNumber());
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    friendsList.add(groupList.get(position).getUserNameId());

                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return groupList.size();
    }




  /*  @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final AdapterShowGroupContacts.ViewHolder holder;
        LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            if (vi != null) {
                convertView = vi.inflate(R.layout.view_all_contact_group, null);
            }
            holder = createViewHolder(convertView);
            if (convertView != null) {
                convertView.setTag(holder);
            }
        } else {
            holder = (RecyclerView.ViewHolder) convertView.getTag();
        }

        final ContactsSelectionModel contactsSelectionModel = new ContactsSelectionModel();

        holder.checkBox.setChecked(.get(position).getIsChecked());
        holder.number.setText(.get(position).getContact());
        holder.contactPic.setImageResource(R.mipmap.ic_launcher_round);

        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.checkBox.isChecked()){
                    .get(position).setIsChecked(true);
                    contactsSelectionModel.setContact(.get(position).getContact());
                    contactsSelectionModel.setIsChecked(.get(position).getIsChecked());
                    Utils.selectedContacts.add(contactsSelectionModel);
                }else {
                    Utils.selectedContacts.remove(contactsSelectionModel);
                }
            }
        });

        return convertView;
    }*/







    class groupViewHolder extends RecyclerView.ViewHolder{

        ImageView userIcon;
        TextView userName;
        TextView userPoneNum;
        CheckBox checkBox;
       // RelativeLayout relativeLayout;

        public groupViewHolder(View itemView) {
            super(itemView);
            userIcon = itemView.findViewById(R.id.contactPic);
            userName = itemView.findViewById(R.id.contactsView);
            userPoneNum= itemView.findViewById(R.id.numberView);
            checkBox=itemView.findViewById(R.id.checkbox);
            //relativeLayout=itemView.findViewById(R.id.contactbar);
        }
    }

}