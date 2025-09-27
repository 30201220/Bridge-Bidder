package com.example.bridgebidder

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible

class BiddingPage : AppCompatActivity() {
//    var allBroad: Array<Board> = arrayOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bidding_page)
        //
        var value_text = findViewById<TextView>(R.id.value_text)
        var south_Board = findViewById<TextView>(R.id.southProcess)
        var north_Board = findViewById<TextView>(R.id.northProcess)
        var east_Board = findViewById<TextView>(R.id.eastProcess)
        var west_Board = findViewById<TextView>(R.id.westProcess)
        var south_bar = findViewById<LinearLayout>(R.id.south_bidding_bar)
        var north_bar = findViewById<LinearLayout>(R.id.north_bidding_bar)
        var west_bar = findViewById<LinearLayout>(R.id.west_bidding_bar)
        var east_bar = findViewById<LinearLayout>(R.id.east_bidding_bar)
        var south_button = findViewById<Button>(R.id.south_check_button)
        var north_button = findViewById<Button>(R.id.north_check_button)
        var east_button = findViewById<Button>(R.id.east_check_button)
        var west_button = findViewById<Button>(R.id.west_check_button)
        var bids_south = findViewById<Spinner>(R.id.south_bid_spinner)
        var bids_north = findViewById<Spinner>(R.id.north_bid_spinner)
        var bids_east = findViewById<Spinner>(R.id.east_bid_spinner)
        var bids_west = findViewById<Spinner>(R.id.west_bid_spinner)
        var calls_south = findViewById<Spinner>(R.id.south_call_spinner)
        var calls_north = findViewById<Spinner>(R.id.north_call_spinner)
        var calls_east = findViewById<Spinner>(R.id.east_call_spinner)
        var calls_west = findViewById<Spinner>(R.id.west_call_spinner)
        var undo_button = findViewById<Button>(R.id.undo)
        var clear_button = findViewById<Button>(R.id.clear)
        var callList = arrayOf("  ","P ", "X ", "XX")
        var bidList = arrayOf("  ",
            "1C", "1D", "1H", "1S", "1N",
            "2C", "2D", "2H", "2S", "2N",
            "3C", "3D", "3H", "3S", "3N",
            "4C", "4D", "4H", "4S", "4N",
            "5C", "5D", "5H", "5S", "5N",
            "6C", "6D", "6H", "6S", "6N",
            "7C", "7D", "7H", "7S", "7N"
        )
//        for (i in Constants.bidMap) {
//            bidList += i.value
//        }

        var adapter_call = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, callList)
        var adapter_bid = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, bidList)

        calls_east.adapter = adapter_call
        calls_west.adapter = adapter_call
        calls_south.adapter = adapter_call
        calls_north.adapter = adapter_call

        bids_south.adapter = adapter_bid
        bids_west.adapter = adapter_bid
        bids_north.adapter = adapter_bid
        bids_east.adapter = adapter_bid

        //broad
        var board = 1
//        var allBroad: Array<Board>

        //spinner
        var boards: Spinner = findViewById(R.id.broad_spinner)
        var numOfBroads: Int = 16;
        intent?.extras?.let {
            numOfBroads = it.getInt("numOfBroads")
//            allBroad = it.getSerializable("board") as Array<Board>
        }
        var broadList = emptyArray<String>()
        for (i in 1..numOfBroads) {
            broadList += ("Broad %d".format(i))
        }
        var adapter_board = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, broadList)
        boards.adapter = adapter_board
        boards.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                    board = position + 1
                    setBoard(south_Board, north_Board, east_Board, west_Board, board)
                    setDealer(south_bar, north_bar, east_bar, west_bar, board)
                    value_text.text = "VUL: %s".format(Constants.boards[board].valueString)
                }
                override fun onNothingSelected(parent: AdapterView<*>) {
                }
            }

        south_button.setOnClickListener {
            var call: String = calls_south.selectedItem.toString()
            var bid: String = bids_south.selectedItem.toString()
            if ((call == "  " && bid == "  ")||(call != "  " && bid != "  ")) {
                Toast.makeText(this@BiddingPage, "wrong selected", Toast.LENGTH_SHORT).show()
            }
            else {
                Constants.boards[board].call(if(bid != "  ") bid else call)
                nextTurn(south_bar, north_bar, east_bar, west_bar, board)
                setBoard(south_Board, north_Board, east_Board, west_Board, board)
            }
        }
        north_button.setOnClickListener {
            var call: String = calls_north.selectedItem.toString()
            var bid: String = bids_north.selectedItem.toString()
            if ((call == "  " && bid == "  ")||(call != "  " && bid != "  ")) {
                Toast.makeText(this@BiddingPage, "wrong selected", Toast.LENGTH_SHORT).show()
            }
            else {
                Constants.boards[board].call(if(bid != "  ") bid else call)
                nextTurn(south_bar, north_bar, east_bar, west_bar, board)
                setBoard(south_Board, north_Board, east_Board, west_Board, board)
            }
        }
        east_button.setOnClickListener {
            var call: String = calls_east.selectedItem.toString()
            var bid: String = bids_east.selectedItem.toString()
            if ((call == "  " && bid == "  ")||(call != "  " && bid != "  ")) {
                Toast.makeText(this@BiddingPage, "wrong selected", Toast.LENGTH_SHORT).show()
            }
            else {
                Constants.boards[board].call(if(bid != "  ") bid else call)
                nextTurn(south_bar, north_bar, east_bar, west_bar, board)
                setBoard(south_Board, north_Board, east_Board, west_Board, board)
            }
        }
        west_button.setOnClickListener {
            var call: String = calls_west.selectedItem.toString()
            var bid: String = bids_west.selectedItem.toString()
            if ((call == "  " && bid == "  ")||(call != "  " && bid != "  ")) {
                Toast.makeText(this@BiddingPage, "wrong selected", Toast.LENGTH_SHORT).show()
            }
            else {
                Constants.boards[board].call(if(bid != "  ") bid else call)
                nextTurn(south_bar, north_bar, east_bar, west_bar, board)
                setBoard(south_Board, north_Board, east_Board, west_Board, board)
            }
        }

        undo_button.setOnClickListener {
            Constants.boards[board].undo()
            setBoard(south_Board, north_Board, east_Board, west_Board, board)
            var turn = Constants.boards[board].turn
            south_bar.isVisible = turn == Constants.Position.south
            north_bar.isVisible = turn == Constants.Position.north
            east_bar.isVisible = turn == Constants.Position.east
            west_bar.isVisible = turn == Constants.Position.west
        }
        clear_button.setOnClickListener {
            Constants.boards[board] = Board(board)
            setBoard(south_Board, north_Board, east_Board, west_Board, board)
            setDealer(south_bar, north_bar, east_bar, west_bar, board)
        }
    }
    fun nextTurn(sb: LinearLayout, nb: LinearLayout, eb: LinearLayout, wb: LinearLayout, board: Int) {
        Constants.boards[board].nextTurn()
        var turn = Constants.boards[board].turn
        sb.isVisible = turn == Constants.Position.south
        nb.isVisible = turn == Constants.Position.north
        eb.isVisible = turn == Constants.Position.east
        wb.isVisible = turn == Constants.Position.west
    }

    fun setDealer(sb: LinearLayout, nb: LinearLayout, eb: LinearLayout, wb: LinearLayout, board: Int) {
        var turn = Constants.boards[board].turn
        sb.isVisible = turn == Constants.Position.south
        nb.isVisible = turn == Constants.Position.north
        eb.isVisible = turn == Constants.Position.east
        wb.isVisible = turn == Constants.Position.west
    }

    fun setBoard(st : TextView, nt : TextView, et : TextView, wt : TextView, broad: Int) {
        var ss = ""
        var ns = ""
        var es = ""
        var ws = ""
        for( i in 1..24) {
            ss += Constants.bidMap.get(Constants.boards[broad].sProcess[i-1]) + " "
            ns += Constants.bidMap.get(Constants.boards[broad].nProcess[i-1]) + " "
            es += Constants.bidMap.get(Constants.boards[broad].eProcess[i-1]) + " "
            ws += Constants.bidMap.get(Constants.boards[broad].wProcess[i-1]) + " "
        }
        st.text = ss
        nt.text = ns
        et.text = es
        wt.text = ws
    }
}