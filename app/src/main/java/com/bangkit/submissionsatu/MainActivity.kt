package com.bangkit.submissionsatu

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bangkit.submissionsatu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

//    private lateinit var recyclerView: RecyclerView
//    private lateinit var agentList: ArrayList<Agent>
//    private lateinit var agentAdapter: AgentAdapter
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val agentAdapter = AgentAdapter(getData())
        binding.rvAgent.adapter = agentAdapter
        binding.rvAgent.layoutManager =
            StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
    when (item.itemId) {
        R.id.action_list -> {
            binding.rvAgent.layoutManager = LinearLayoutManager(this)
        }
        R.id.action_grid -> {
            binding.rvAgent.layoutManager = GridLayoutManager(this, 2)
        }
        R.id.action_about -> {
            startActivity(Intent(this@MainActivity, AboutActivity::class.java))
            true
        }
    }
    return super.onOptionsItemSelected(item)
}

        fun getData(): ArrayList<Agent>{
            val agentImage = resources.getStringArray(R.array.img_list)
            val agentName = resources.getStringArray(R.array.name_agent)
            val agentExplanation = resources.getStringArray(R.array.explanation_agent)
            val agentDetails = resources.getStringArray(R.array.details_agent)

            var listAgent = ArrayList<Agent>()
            for (i in agentName.indices){
                val agent =
                    Agent(agentImage[i], agentName[i], agentExplanation[i], agentDetails[i])
                listAgent.add(agent)
            }
            Log.d("debug", "getData: $listAgent")
            return listAgent
        }



//        agentList.add(Agent(R.drawable.jett_artwork, "Jett", "Representing her home country of South Korea, Jett's agile and evasive fighting style lets her take risks no one else can. She runs circles around every skirmish, cutting enemies before they even know what hit them." ))
//        agentList.add(Agent(R.drawable.kayo_artwork, "KAY/O", "KAY/O is a machine of war built for a single purpose: neutralizing radiants. His power to suppress enemy abilities dismantles his opponents' capacity to fight back, securing him and his allies the ultimate edge." ))
//        agentList.add(Agent(R.drawable.killjoy_artwork, "Killjoy", "The genius of Germany, Killjoy effortlessly secures key battlefield positions with her arsenal of inventions. If their damage doesn't take her enemies out, the debuff her robots provide will make short work of them." ))
//        agentList.add(Agent(R.drawable.neon_artwork, "Neon", "Filipino Agent, Neon, surges forward at shocking speeds, discharging bursts of bioelectric radiance as fast as her body generates it. She races ahead to catch enemies off guard, then strikes them down quicker than lightning." ))
//        agentList.add(Agent(R.drawable.omen_artwork, "Omen", "A phantom of a memory, Omen hunts in the shadows. He renders enemies blind, teleports across the field, then lets paranoia take hold as his foe scrambles to learn where he might strike next." ))
//        agentList.add(Agent(R.drawable.sova_artwork, "Sova", "Born from the eternal winter of Russia's tundra, Sova tracks, finds, and eliminates enemies with ruthless efficiency and precision. His custom bow and incredible scouting abilities ensure that even if you run, you cannot hide." ))


}