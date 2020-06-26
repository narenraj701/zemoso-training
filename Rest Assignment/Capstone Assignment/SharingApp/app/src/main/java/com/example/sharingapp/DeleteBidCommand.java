package com.example.sharingapp;

import android.content.Context;

/**
 * Command to delete a bid
 */
public class DeleteBidCommand extends Command {

    
    private Bid bid;
    

    public DeleteBidCommand( Bid bid) {
        this.bid = bid;
    }

    // Delete bid remotely
    public void execute(){
       ElasticSearchManager.RemoveBidTask remove_bid = new ElasticSearchManager.RemoveBidTask();
        Remove_bid.execute(bid);

        try {
            if(remove_bid.get()) {
                super.setIsExecuted(true);
            }
         catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            super.setIsExecuted(false);
        }
       
    }
}

