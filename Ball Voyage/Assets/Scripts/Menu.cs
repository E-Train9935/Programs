using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;

public class Menu : MonoBehaviour
{
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        
    }

    public void OnQuitClick()
    {
        Application.Quit();
        Debug.Log("Exiting game");
    }

    public void OnCreditsClick()
    {
        SceneManager.LoadScene("Credits");
        Debug.Log("Credits clicked, now going to Credits scene");
    }

    public void OnInstructionsClick()
    {
        SceneManager.LoadScene("Instructions");
        Debug.Log("Instructions clicked, now going to Instructions scene");
    }

    public void PlayGame()
    {
        SceneManager.LoadScene("GameScene");
        Debug.Log("Play Game clicked, now going to Game scene");
    }

    public void OnBackToMenuClick()
    {
        SceneManager.LoadScene("Menu");
        Debug.Log("Back to Menu clicked, now going to Menu scene");
    }
}
