using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class ObstacleController : MonoBehaviour
{

    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {

    }

    void OnCollisionEnter(Collision collision)
    {
        Destroy(collision.collider.gameObject);
        //Destroy(gameObject);

        if (gameObject.name != "FinishLine")
            SceneManager.LoadScene("GameOver");
        else
            SceneManager.LoadScene("GameComplete");
    }


}
