/**
 * register a popup for a button
 * @param id
 * @param confirmCallBack
 * @param cancelCallBack
 */
function registerPopUp(id, confirmCallBack, cancelCallBack) {
	 $(id).dialog({
		 modal: true,
		 buttons: {
			     "Confirm": function() {
	    		     // Do some proessing here. Like making an AJAX call to process payment.
			    	 if(null != confirmCallBack)
			    		 confirmCallBack();
	    		     $( this ).dialog( "close" );
	    		 },
	    		 "Cancel": function() {
	    			 if(null != cancelCallBack)
	    				 cancelCallBack();
	    		     $( this ).dialog( "close" );
	    		 }
			 }
	 });
}