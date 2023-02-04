using System.Collections;
using System.Collections.Generic;
using System.Diagnostics;
using System.Threading;
using UnityEngine;

public class BallMechanics : MonoBehaviour
{
    public float playerSpeed = 2;

    private Rigidbody rb;

    // Start is called before the first frame update
    void Start()
    {
        rb = GetComponent<Rigidbody>();
    }

    // Update is called once per frame
    void Update()
    {
        rb.velocity = new Vector3(-1 * playerSpeed, 0, 0);

        if (Input.GetKey(KeyCode.A)) 
        { 
            rb.AddForce(Vector3.left);
            rb.velocity = new Vector3(-1 * playerSpeed, 0, -1*100);
        }

        if (Input.GetKey(KeyCode.D))
        {
            rb.AddForce(Vector3.right);
            rb.velocity = new Vector3(-1 * playerSpeed, 0, 100);
        }
    }
}
