//package com.example.android.miwok;

/**
 * Created by Michelle Tan on 6/3/2017.
 */

//public class WordAdapter extends ArrayAdapter<Word> {
//
//    @Override
//
//    public View getView(int position, View convertView, ViewGroup parent) {
//        // Check if the existing view is being reused, otherwise inflate the view
//        View listItemView = convertView;
//        if(listItemView == null) {
//            listItemView = LayoutInflater.from(getContext()).inflate(
//                    R.layout.listview1, parent, false);
//        }
//
//        // Get the {@link AndroidFlavor} object located at this position in the list
//        Word currentWord = getItem(position);
//
//        // Find the TextView in the list_item.xml layout with the ID version_name
//        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.defaulttext1);
//        // Get the version name from the current AndroidFlavor object and
//        // set this text on the name TextView
//        defaultTextView.setText(currentWord.getDefaultTranslation());
//
//        // Find the TextView in the list_item.xml layout with the ID version_number
//        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwoktext1);
//        // Get the version number from the current AndroidFlavor object and
//        // set this text on the number TextView
//        miwokTextView.setText(currentWord.getMiwokTranslation());
//
//        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
////        ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
////        // Get the image resource ID from the current AndroidFlavor object and
////        // set the image to iconView
////        iconView.setImageResource(currentAndroidFlavor.getImageResourceId());
//
//        // Return the whole list item layout (containing 2 TextViews and an ImageView)
//        // so that it can be shown in the ListView
//        return listItemView;
//    }
//}
